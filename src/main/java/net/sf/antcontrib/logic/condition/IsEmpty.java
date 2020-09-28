/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package net.sf.antcontrib.logic.condition;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.ProjectComponent;
import org.apache.tools.ant.taskdefs.condition.Condition;

/**
 * Check if a property is empty. That mean the property is null or an empty {@link String}.
 * 
 * @author <a href="mailto:msi@top-logic.com">msi</a>
 */
public class IsEmpty extends ProjectComponent implements Condition {
    private String property;

    /**
     * Set the property attribute
     *
     * @param p the property name
     */
    public void setProperty(String p) {
        property = p;
    }

    /**
     * @return true if the property is null or empty {@link String}.
     * @exception BuildException if the property attribute is not set
     */
    @Override
    public boolean eval() {
        if (property == null) {
			throw new BuildException(
				"No property specified for isempty condition");
        }

		String value = getProject().getProperty(property);
		return value == null || value.isEmpty();
    }

}