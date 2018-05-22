
import com.mkdika.jeneric.function.DateFun;
import com.mkdika.jeneric.function.StringFun;
import java.util.Date;
import org.junit.Test;

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

/**
 *
 * @author Maikel Chandika (mkdika@gmail.com)
 */
public class Testing {
    
    @Test
    public void testing1() {
        String s = "F25A2FC72690B780B2A14E140EF6A9E0";
        System.out.println(StringFun.rightTrim(s, 4));
        System.out.println(StringFun.getUUID());
        System.out.println(s.toLowerCase());
    }
    
}
