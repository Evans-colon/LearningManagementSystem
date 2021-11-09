package com.ileiwe.data.service.event;

import com.ileiwe.data.model.LearningParty;
import lombok.Data;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

@Getter
public class OnRegistrationCompleteEvent extends ApplicationEvent {

    private LearningParty appUser;

    public OnRegistrationCompleteEvent(LearningParty source) {
        super(source);
        this.appUser = source;
    }

}
