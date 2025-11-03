package Lecteurs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public abstract class AbstractFile implements IAbstractFile
{
	protected String cheminFichier;
	protected ArrayList<String> contenu;
	
	public AbstractFile(String cheminFichier)
	{
		this.cheminFichier = cheminFichier;
	}
	
	@Override
	public void lireFichier()
	{
		this.contenu = lectureDuFichier();
	}
	
	protected ArrayList<String> lectureDuFichier() 
	{
		ArrayList<String> lignes = new ArrayList<>();
		try
		{
			lignes.addAll(Files.readAllLines(Paths.get(cheminFichier)));
		}
		catch (IOException e)
		{
			System.err.println("Erreur fichier : " + e.getMessage() + " est introuvable.");
		}
		return lignes;
	}
	
	//methode privee lecture du fichier sans librairie java
	@SuppressWarnings("unused")
	private void lectureDuFichierSansLibrairie()
	{
		File f = new File(cheminFichier);
		try {
		      FileInputStream in = new FileInputStream(f);
		      int i = in.read();
		      while (i != -1) {
		    	  System.out.println((char) i);
		    	  i = in.read();
		      }
		      in.close();
		    } catch (Exception e) {
		      e.getStackTrace();
		}
	}
	
	public void afficherFichier()
	{
		for(String ligne : contenu) 
		{
			System.out.println(ligne);
		}
	}
	
	public void inverserFichier()
	{
		Collections.reverse(contenu);
		for(String ligne : contenu) 
		{
			System.out.println(ligne);
		}
		
	}
	
	public void creerPalindrome()
	{
		for (String ligne : contenu)
		{			
			StringBuffer palindrome = new StringBuffer(ligne);
			palindrome.reverse();
			System.out.println(palindrome);
		}
	}
	
	public ArrayList<String> getContenu()
	{
		return this.contenu;
	}
	
	public boolean compareTo(AbstractFile contenu) {
	    return this.contenu.equals(getContenu());
	}
}
