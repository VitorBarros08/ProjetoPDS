package br.imd.pds.model;

import java.util.ArrayList;

import br.imd.pds.exceptions.*;
import java.io.InvalidObjectException;

public class ManageSector
{
	ArrayList<Sector> sectors;
	
	public ManageSector()
	{
		sectors = new ArrayList<Sector>();
	}
	
	public void createSector(int id, String name) throws ExistentObjectException
	{
		for(int index = 0; index < sectors.size(); index++)
		{
			if(sectors.get(index).getName().equalsIgnoreCase(name))
			{
				throw new ExistentObjectException("Já existe um setor registrado com esse nome");
			}
		}
		
		Sector newSector = new Sector(id, name);
		
		sectors.add(newSector);
	}
	
	public void deleteSector(String name) throws InexistentSectorException
	{
		for(int index = 0; index < sectors.size(); index++)
		{
			if(sectors.get(index).getName().equalsIgnoreCase(name))
			{
				sectors.remove(index);
				return;
			}
		}
		
		throw new InexistentSectorException("Setor inexistente");
	}
	
	public void updateSector(String name, String newName) throws ExistentObjectException, InexistentSectorException
	{
		Sector foundOne = null;
		
		for(int index = 0; index < sectors.size(); index++)
		{
			if(sectors.get(index).getName().equalsIgnoreCase(newName))
			{
				throw new ExistentObjectException("Já existe um setor registrado com o novo nome");	
			
			} else if(sectors.get(index).getName().equalsIgnoreCase(name)){
				
				foundOne = sectors.get(index);
			}
		}
		
		if(foundOne != null)
		{
			foundOne.setName(newName);
			
		} else {
			
			throw new InexistentSectorException("Setor inexistente");
		}
	}
	
	public Sector searchSector(String name) throws InexistentSectorException
	{
		for(int index = 0; index < sectors.size(); index++)
		{
			if(sectors.get(index).getName().equalsIgnoreCase(name))
			{
				return sectors.get(index);
			}
		}
		
		throw new InexistentSectorException("Setor inexistente");
	}
	
	public void schedule()
	{
		
	}
	
	public void reschedule()
	{
		
	}
}