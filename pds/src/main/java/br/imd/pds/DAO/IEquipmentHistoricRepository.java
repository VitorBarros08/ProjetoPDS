package br.imd.pds.DAO;
import org.springframework.data.jpa.repository.JpaRepository;

import br.imd.pds.model.EquipmentHistoric;

public interface IEquipmentHistoricRepository extends JpaRepository<EquipmentHistoric,Long>{
	public void insertEquipmentHistoric();
	public void deleteEquipmentHistoric();
	public void updateEquipmentHistoric();
	public EquipmentHistoric searchEquipmentHistoric();	
}
