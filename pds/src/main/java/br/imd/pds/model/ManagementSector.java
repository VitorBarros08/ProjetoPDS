package br.imd.pds.model;

import br.imd.pds.helpers.*;
import br.imd.pds.repository.ISectorRepository;

import java.io.InvalidObjectException;

public class ManagementSector {
	
	private ISectorRepository sectorRepository;
	
	public ManagementSector(ISectorRepository sectorRepository) {
		this.sectorRepository = sectorRepository;
	}
	
	public void createSector(Sector sector) throws ExistentObjectException {

	}
	
	public void deleteSector(String name) throws InexistentObjectException {
	
	}
	
	public void updateSector() throws ExistentObjectException, InexistentObjectException
	{
		
	}
	
	public Sector searchSector(String name) throws InexistentObjectException {
		
		Sector sec = null;
		
		return sec;
	}
	
	public void schedule() {
		
	}
	
	public void reschedule() {
		
	}
}
