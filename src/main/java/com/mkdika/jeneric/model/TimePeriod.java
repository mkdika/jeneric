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
package com.mkdika.jeneric.model;

/**
 *
 * @author Maikel Chandika <mkdika@gmail.com>
 */
public final class TimePeriod {

    private final long days;
    private final long hours;
    private final long minutes;
    private final long seconds;
    private final long milliseconds;

    public TimePeriod(long days, long hours, long minutes, long seconds, long milliseconds) {
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.milliseconds = milliseconds;
    }

    public long getDays() {
        return days;
    }

    public long getHours() {
        return hours;
    }

    public long getMinutes() {
        return minutes;
    }

    public long getSeconds() {
        return seconds;
    }

    public long getMilliseconds() {
        return milliseconds;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(this.days).append("D");
        sb.append(this.hours).append("H");
        sb.append(this.minutes).append("M");
        sb.append(this.seconds).append("S");
        sb.append(this.milliseconds).append("MS");
        
        return sb.toString();
    }
}
