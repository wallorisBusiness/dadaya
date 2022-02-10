package com.mohmolloris.dadaya.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserWithBigPinus {
    String name;
    double age;
    int pinus;
    List<String> nicknames;
    DitkaProfile ditkaProfile;
}

@Data
class DitkaProfile {
    int countOfHoursInGame;
}
