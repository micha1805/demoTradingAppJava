package com.trading.app.demo.service;

import com.trading.app.demo.model.Wire;
import com.trading.app.demo.repository.UserRepository;
import com.trading.app.demo.repository.WireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WireService {
    private final UserRepository userRepository;
    private final WireRepository wireRepository;

}
