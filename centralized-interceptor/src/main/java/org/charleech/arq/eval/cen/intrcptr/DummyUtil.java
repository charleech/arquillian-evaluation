package org.charleech.arq.eval.cen.intrcptr;

import lombok.extern.slf4j.Slf4j;

import org.charleech.arq.eval.cen.intrcptr.ftprnt.FootprintInterceptable;
import org.charleech.arq.eval.cen.intrcptr.prfrmnc.PerformanceInterceptable;

@FootprintInterceptable
@PerformanceInterceptable
@Slf4j
public class DummyUtil {

    public void dummyUtil() {
        DummyUtil.log.info("This is dummy util");
    }
}
