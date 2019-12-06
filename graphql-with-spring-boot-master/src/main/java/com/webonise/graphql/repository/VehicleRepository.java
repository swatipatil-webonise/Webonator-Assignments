package com.webonise.graphql.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.webonise.graphql.entity.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
	
	@Modifying
	@Transactional
	@Query("delete from Vehicle where id = :id")
	public int deleteVehicleById(@Param("id") int id);
	
	@Modifying
	@Transactional
	@Query("update Vehicle vehicle set vehicle.type = :type, vehicle.modelCode = :modelCode, vehicle.brandName = :brandName where vehicle.id = :id")
	public int update(@Param("id") int id, @Param("type") String type, @Param("modelCode") String modelCode, @Param("brandName") String brandName);
}
