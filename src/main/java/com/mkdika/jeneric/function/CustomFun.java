/*
 * Copyright 2018 Maikel Chandika (mkdika@gmail.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mkdika.jeneric.function;

import com.mkdika.jeneric.model.TimePeriod;
import java.util.Date;

/**
 *
 * @author Maikel Chandika <mkdika@gmail.com>
 */
public final class CustomFun {

    /*
        To prevent class from instanate from outside.
     */
    private CustomFun() {
    }

    public static TimePeriod calculatePeriod(Date startDate, Date endDate) {
        return calculatePeriod(startDate.getTime(), endDate.getTime());
    }

    public static TimePeriod calculatePeriod(long startTime, long endTime) {
        if (endTime < startTime) {
            throw new IllegalArgumentException("End date must be equals or greater than start date.");
        }
        
        long different = endTime - startTime;      
        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        long elapsedSeconds = different / secondsInMilli;
        different = different % secondsInMilli;

        return new TimePeriod(elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds, different);
    }
}
