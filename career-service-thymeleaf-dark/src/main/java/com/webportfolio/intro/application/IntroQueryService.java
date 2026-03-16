package com.webportfolio.intro.application;

import com.webportfolio.intro.domain.IntroProfile;
import com.webportfolio.intro.infrastructure.InMemoryIntroRepository;
import org.springframework.stereotype.Service;

@Service
public class IntroQueryService {

    private final InMemoryIntroRepository introRepository;

    public IntroQueryService(InMemoryIntroRepository introRepository) {
        this.introRepository = introRepository;
    }

    public IntroProfile getProfile() {
        return introRepository.getProfile();
    }
}
