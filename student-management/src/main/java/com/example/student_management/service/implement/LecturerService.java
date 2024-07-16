package com.example.student_management.service;

import com.example.student_management.dto.lecturer.AddLecturerDTO;
import com.example.student_management.dto.lecturer.LecturerDTO;
import com.example.student_management.dto.lecturer.UpdateLecturerDTO;
import com.example.student_management.exception.AppException;
import com.example.student_management.exception.ErrorCode;
import com.example.student_management.model.Lecturer;
import com.example.student_management.model.ManagementClass;
import com.example.student_management.repository.LecturerRepository;
import com.example.student_management.service.abstracts.ILecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LecturerService implements ILecturerService {

    private final LecturerRepository lecturerRepository;
    private final ManagementClassService managementClassService;

    @Autowired
    public LecturerService(LecturerRepository lecturerRepository, ManagementClassService managementClassService) {
        this.lecturerRepository = lecturerRepository;
        this.managementClassService = managementClassService;
    }

    private LecturerDTO convertTODTO(Lecturer lecturer){
        return new LecturerDTO(
                lecturer.getLecturerId(),
                lecturer.getFirstName(),
                lecturer.getLastName(),
                lecturer.getEmail(),
                lecturer.getPhoneNumber(),
                lecturer.getAddress(),
                lecturer.getGender(),
                lecturer.getDateOfBirth(),
                lecturer.getFacultyId(),
                lecturer.getManagementClass().getManagementClassId()
        );
    }

    @Override
    public List<LecturerDTO> findAll() {
        return lecturerRepository.findAll()
                .stream().map(this::convertTODTO)
                .collect(Collectors.toList());
    }

    @Override
    public LecturerDTO findLecturerById(Long id) {
        return lecturerRepository.findById(id)
                .map(this::convertTODTO)
                .orElseThrow(() -> new AppException(ErrorCode.LECTURER_NOT_FOUND));
    }

    @Override
    public Optional<Lecturer> findLecturerByIdForService(Long id) {
        return lecturerRepository.findById(id);
    }

    @Override
    public List<LecturerDTO> findLecturerByName(String name) {
        return lecturerRepository.findAll()
                .stream().map(this::convertTODTO)
                .filter(l -> l.getFirstName().contains(name) || l.getLastName().contains(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<LecturerDTO> findLecturerByFacultyId(Long id) {
        boolean isExist = lecturerRepository.findAll().stream()
                .anyMatch(lecturer -> lecturer.getFacultyId().equals(id));

        if(!isExist){
            throw new AppException(ErrorCode.FACULTY_NOT_FOUND);
        }

        return lecturerRepository.findAll().stream()
                .map(this::convertTODTO)
                .filter(lecturer -> lecturer.getFacultyId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public LecturerDTO findLecturerByManagementClassId(Long id) {
        boolean isExist = lecturerRepository.findAll().stream()
                .anyMatch(lecturer -> lecturer.getManagementClass().getManagementClassId().equals(id));
    
        if(!isExist){
            throw new AppException(ErrorCode.MANAGEMENT_CLASS_NOT_FOUND);
        }
    
        return lecturerRepository.findAll().stream()
                .map(this::convertTODTO)
                .filter(lecturer -> lecturer.getManagementClassId().equals(id))
                .findFirst()
                .orElseThrow(() -> new AppException(ErrorCode.LECTURER_NOT_FOUND));
    }

    @Override
    public UpdateLecturerDTO updateLecturer(UpdateLecturerDTO updateLecturerDTO) {
        Lecturer lecturer = lecturerRepository.findById(updateLecturerDTO.id)
                .orElseThrow(() -> new AppException(ErrorCode.LECTURER_NOT_FOUND));

        lecturer.setFirstName(updateLecturerDTO.getFirstName());
        lecturer.setLastName(updateLecturerDTO.getLastName());
        lecturer.setAddress(updateLecturerDTO.getAddress());
        lecturer.setDateOfBirth(updateLecturerDTO.getDateOfBirth());
        lecturer.setEmail(updateLecturerDTO.getEmail());
        lecturer.setGender(updateLecturerDTO.getGender());
        lecturer.setPhoneNumber(updateLecturerDTO.getPhoneNumber());

        boolean isExist = lecturerRepository.findAll().stream()
                .anyMatch(l -> l.getManagementClass().getManagementClassId().equals(updateLecturerDTO.managementClassId));

        if(isExist){
            throw new AppException(ErrorCode.ANOTHER_LECTURER_IN_MANAGEMENT_CLASS);
        }

        ManagementClass managementClass = managementClassService
                .findManagementClassByIdForService(updateLecturerDTO.getManagementClassId())
                .orElseThrow(() -> new AppException(ErrorCode.MANAGEMENT_CLASS_NOT_FOUND));

        lecturer.setManagementClass(managementClass);
        lecturer.setFacultyId(updateLecturerDTO.getFacultyId());
        lecturerRepository.save(lecturer);

        return updateLecturerDTO;
    }

    @Override
    public AddLecturerDTO addLecturer(AddLecturerDTO addLecturerDTO) {
        if (lecturerRepository.existsByEmail(addLecturerDTO.getEmail())) {
            throw new AppException(ErrorCode.EMAIL_EXISTED);
        }
        if (lecturerRepository.existsByPhoneNumber(addLecturerDTO.getPhoneNumber())) {
            throw new AppException(ErrorCode.PHONE_NUMBER_EXISTED);
        }
        Lecturer lecturer = new Lecturer();
        lecturer.setFirstName(addLecturerDTO.getFirstName());
        lecturer.setLastName(addLecturerDTO.getLastName());
        lecturer.setEmail(addLecturerDTO.getEmail());
        lecturer.setGender(addLecturerDTO.getGender());
        lecturer.setAddress(addLecturerDTO.getAddress());
        lecturer.setPhoneNumber(addLecturerDTO.getPhoneNumber());
        lecturer.setDateOfBirth(addLecturerDTO.getDateOfBirth());
        lecturer.setFacultyId(addLecturerDTO.getFacultyId());
        boolean isExist = lecturerRepository.findAll().stream()
                .anyMatch(l -> l.getManagementClass().getManagementClassId().equals(addLecturerDTO.managementClassId));

        if(isExist){
            throw new AppException(ErrorCode.ANOTHER_LECTURER_IN_MANAGEMENT_CLASS);
        }
        
        ManagementClass managementClass = managementClassService
                .findManagementClassByIdForService(addLecturerDTO.managementClassId)
                .orElseThrow(() -> new AppException(ErrorCode.MANAGEMENT_CLASS_NOT_FOUND));

        lecturer.setManagementClass(managementClass);
        lecturerRepository.save(lecturer);
        return addLecturerDTO;
    }

    @Override
    public void deleteLecturer(Long id) {
        Lecturer lecturer = lecturerRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.LECTURER_NOT_FOUND));
        lecturerRepository.delete(lecturer);
    }
}
