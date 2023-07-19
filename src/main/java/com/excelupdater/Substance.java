package com.excelupdater;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Substance {

    @Getter @Setter private String indexNo;
    @Getter @Setter private String ICE;
    @Getter @Setter private String ecNo;
    @Getter @Setter private String casNo;
    @Getter @Setter private String HSC;

}
