package com.chtrembl.petstore.pet.service;

import com.chtrembl.petstore.pet.mapper.PetModelMapper;
import com.chtrembl.petstore.pet.model.DataPreload;
import com.chtrembl.petstore.pet.model.Pet;
import com.chtrembl.petstore.pet.repository.PetStorePetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PetService {

    private final DataPreload dataPreload;
    private final PetStorePetRepository petStorePetRepository;
    private final PetModelMapper petMapper;

    public List<Pet> findPetsByStatus(List<String> status) {
        log.info("Finding pets with status: {}", status);
        List<com.chtrembl.petstore.pet.entity.Pet> petsByStatus = petStorePetRepository.findByStatusIn(status);
        return petMapper.toPetModelList(petsByStatus);

//        return dataPreload.getPets().stream()
//                .filter(pet -> status.contains(pet.getStatus().getValue()))
//                .toList();
    }

    public Optional<Pet> findPetById(Long petId) {
        log.info("Finding pet with id: {}", petId);
        return Optional.of(petMapper.toPetModel(petStorePetRepository.findById(petId)
                .orElse(null)));

//        return dataPreload.getPets().stream()
//                .filter(pet -> pet.getId().equals(petId))
//                .findFirst();
    }

    public List<Pet> getAllPets() {
        log.info("Getting all pets");
        List<com.chtrembl.petstore.pet.entity.Pet> allPets = petStorePetRepository.findAll();
        return petMapper.toPetModelList(allPets);
//        return dataPreload.getPets();
    }

    public int getPetCount() {
        return petStorePetRepository.findAll().size();
//        return dataPreload.getPets().size();
    }
}