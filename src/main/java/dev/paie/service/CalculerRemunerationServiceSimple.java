package dev.paie.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.util.PaieUtils;

@Transactional
@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	private PaieUtils paieUtils;
	private BulletinSalaireRepository bulletinSalaireRepository;

	@Autowired
	public CalculerRemunerationServiceSimple(PaieUtils paieUtils, BulletinSalaireRepository bulletinSalaireRepository) {
		super();
		this.paieUtils = paieUtils;
		this.bulletinSalaireRepository = bulletinSalaireRepository;
	}

	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		BigDecimal salaireBase = bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase()
				.multiply(bulletin.getRemunerationEmploye().getGrade().getTauxBase());
		BigDecimal salaireBrut = salaireBase.add(bulletin.getPrimeExceptionnelle());
		BigDecimal totalRetenueSalariale = new BigDecimal(0);
		for (int i = 0; i < bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables()
				.size(); i++) {
			if (bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables().get(i)
					.getTauxSalarial() != null) {
				totalRetenueSalariale = totalRetenueSalariale
						.add(bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables()
								.get(i).getTauxSalarial().multiply(salaireBrut));
			}
		}
		BigDecimal totalCotisationPatronales = new BigDecimal(0);
		for (int i = 0; i < bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables()
				.size(); i++) {
			if (bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables().get(i)
					.getTauxPatronal() != null) {
				totalCotisationPatronales = totalCotisationPatronales
						.add(bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables()
								.get(i).getTauxPatronal().multiply(salaireBrut));
			}
		}
		BigDecimal salaireBruteA = new BigDecimal(paieUtils.formaterBigDecimal(salaireBrut));
		BigDecimal TotalretenuSalarialA = new BigDecimal(paieUtils.formaterBigDecimal(totalRetenueSalariale));

		BigDecimal netImposable = salaireBruteA.subtract(TotalretenuSalarialA);

		BigDecimal netAPayer = new BigDecimal(0);

		for (int i = 0; i < bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables()
				.size(); i++) {
			if (bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables().get(i)
					.getTauxSalarial() != null) {
				netAPayer = netAPayer.subtract(bulletin.getRemunerationEmploye().getProfilRemuneration()
						.getCotisationsImposables().get(i).getTauxSalarial().multiply(salaireBrut));
			}
		}
		netAPayer = netAPayer.add(netImposable);

		ResultatCalculRemuneration resultat = new ResultatCalculRemuneration(paieUtils.formaterBigDecimal(salaireBase),
				paieUtils.formaterBigDecimal(salaireBrut), paieUtils.formaterBigDecimal(totalRetenueSalariale),
				paieUtils.formaterBigDecimal(totalCotisationPatronales), paieUtils.formaterBigDecimal(netImposable),
				paieUtils.formaterBigDecimal(netAPayer));
		return resultat;
	}

	public Map<BulletinSalaire, ResultatCalculRemuneration> resultat() {

		HashMap<BulletinSalaire, ResultatCalculRemuneration> resultat = new HashMap();
		List<BulletinSalaire> bulletins = bulletinSalaireRepository.findAll();
		for (BulletinSalaire bulletin : bulletins) {
			resultat.put(bulletin, calculer(bulletin));

		}

		return resultat;

	}

	@Override
	public BulletinResultatCalcul recupererBulletinAvecCalcul(Integer id) {
		BulletinSalaire bulletinSalaire = bulletinSalaireRepository.findOne(id);

		return new BulletinResultatCalcul(bulletinSalaire, calculer(bulletinSalaire));
	}

}
