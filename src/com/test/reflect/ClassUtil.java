/**
 *  Copyright 2009 Welocalize, Inc. 
 *  
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  
 *  You may obtain a copy of the License at 
 *  http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  
 */

package com.test.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import junit.framework.Assert;

public class ClassUtil
{
    public static void updateField(Object clazz, String name, Object value)
            throws SecurityException, NoSuchFieldException,
            IllegalArgumentException, IllegalAccessException
    {
        Field f = clazz.getClass().getDeclaredField(name);
        f.setAccessible(true);
        f.set(clazz, value);
    }

    public static Object testMethod(Object clazz, String name,
            Object... objects)
    {
        Method[] ms = clazz.getClass().getDeclaredMethods();
        Method rMethod = null;
        for (Method m : ms)
        {
            String mName = m.getName();
            if (mName.equals(name))
            {
                if (objects != null
                        && objects.length != m.getParameterTypes().length)
                {
                    continue;
                }

                rMethod = m;
                break;
            }
        }

        Assert.assertNotNull("Can not find the method " + name, rMethod);

        rMethod.setAccessible(true);
        try
        {
            return rMethod.invoke(clazz, objects);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.assertFalse(true);
        }

        return null;
    }
}
