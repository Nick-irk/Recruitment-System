package com.fedag.recruitmentSystem.service.impl;

import com.fedag.recruitmentSystem.dto.UserResponse;
import com.fedag.recruitmentSystem.exception.ObjectNotFoundException;
import com.fedag.recruitmentSystem.map.UserMapper;
import com.fedag.recruitmentSystem.model.User;
import com.fedag.recruitmentSystem.repository.UserRepository;
import com.fedag.recruitmentSystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService<UserResponse> {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponse> getAllUsers() {
        return userMapper.modelToDto(userRepository.findAll());
    }

    @Override
    public Page<UserResponse> getAllUsers(Pageable pageable) {
        return userMapper.modelToDto(userRepository.findAll(pageable));
    }

    public List<UserResponse> getByEntranceExamScore(int score) {
        return userMapper.modelToDto(userRepository.findByEntranceExamScore(score));
    }

    public List<UserResponse> getByStars(byte stars) {
        return userMapper.modelToDto(userRepository.findByStars(stars));
    }

    public List<UserResponse> getByExperience() {
        return userMapper.modelToDto(userRepository.findByExperience());
    }

    @Override
    public UserResponse findById(Long id) {
        User user = userRepository
                .findById(id)
                .orElseThrow(
                        () -> new ObjectNotFoundException("User with id: " + id + " not found")
                );
        return userMapper.modelToDto(user);
    }

    @Override
    public void save(UserResponse userResponse) {
        User user = userMapper.dtoToModel(userResponse);
        userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}