package com.example.ApiAttornatus.repositories;

import com.example.ApiAttornatus.dto.AddressDTO;
import com.example.ApiAttornatus.entities.Address;
import com.example.ApiAttornatus.entities.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAddressesByPeopleId(Long people_id);

    List<Address> findAddressesByIsMainAddressAndPeopleId(boolean isMainAddress, Long people_id);
}
