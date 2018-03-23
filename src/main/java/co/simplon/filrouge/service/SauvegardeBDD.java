package co.simplon.filrouge.service;

import java.io.File;
import java.io.IOException;

public class SauvegardeBDD {

	public void sauvegarderBDD() {
		try {

			Runtime.getRuntime().exec(
					// 1 - La commande a exécuter (le shell), en séparant les paramètres :
					new String[] { "cmd.exe", "/C", "C:\\Program Files\\MySQL\\MySQL Workbench 6.3 CE\\mysqldump.exe --user=admin --password=admin fil_rouge > C:\\base.sql" },
					// 2 - Les variables d'environnements (null = hérité du parent)
					null,
					// 3 - Le répertoire de travail
					new File("C:\\data\\SauvegardeBDD\\"));

		} catch (IOException e) {
			System.out.println("erreur");
		}
	}

	public void importerBDD() {
		try{
			 Runtime.getRuntime().exec(
					new String[] {
						"cmd.exe", 
						"/C",
			// il faut remplacer mysqldump par mysql dans le cas d' importation			
			"mysql.exe --user=admin --password=admin fil_rouge < C:\\base.sql" },
					null,
					new File("C:\\data\\SauvegardeBDD\\")
				);
			 
			  }catch(IOException e){ System.out.println("erreur"); }
	}
}