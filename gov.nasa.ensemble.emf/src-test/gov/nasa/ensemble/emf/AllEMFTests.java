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
package gov.nasa.ensemble.emf;

import gov.nasa.ensemble.common.EnsembleJUnit4Suite;
import gov.nasa.ensemble.emf.constraint.TestAttributeValueConstraints;
import gov.nasa.ensemble.emf.constraint.TestTransactionRecordingUndoableOperation;
import gov.nasa.ensemble.emf.patch.AllPatchTestWithAllFeatureTypes;
import gov.nasa.ensemble.emf.transaction.TestTransactionUtils;
import gov.nasa.ensemble.emf.util.TestEMFUtils;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestAttributeValueConstraints.class,
	TestEMFUtils.class,
	TestTransactionRecordingUndoableOperation.class,
	TestTransactionUtils.class,
	TestProjectURIConverter.class,
	AllPatchTestWithAllFeatureTypes.class,
})
public class AllEMFTests extends EnsembleJUnit4Suite {/**/}
