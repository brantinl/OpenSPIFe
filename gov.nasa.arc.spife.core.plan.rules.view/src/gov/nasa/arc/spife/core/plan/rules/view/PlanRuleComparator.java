/*******************************************************************************
 * Copyright 2014 United States Government as represented by the
 * Administrator of the National Aeronautics and Space Administration.
 * All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package gov.nasa.arc.spife.core.plan.rules.view;

import gov.nasa.ensemble.dictionary.ERule;

import java.util.Comparator;

public class PlanRuleComparator implements Comparator<ERule> {

	public static PlanRuleComparator INSTANCE = new PlanRuleComparator();
	
	public int compare(ERule rule1, ERule rule2) {
		int result = String.CASE_INSENSITIVE_ORDER.compare(rule1.getPrintName(), rule2.getPrintName());
		if (result == 0) {
			result = String.CASE_INSENSITIVE_ORDER.compare(rule1.getShortDescription(), rule2.getShortDescription());
		}
		return result;
	}

}
