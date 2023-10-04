package com.blumbit.web.api.store.service.impl;

import com.blumbit.web.api.store.dto.TrackDto;

public interface ITrackService {

    TrackDto getTrackRecord(Integer trackId);
}
