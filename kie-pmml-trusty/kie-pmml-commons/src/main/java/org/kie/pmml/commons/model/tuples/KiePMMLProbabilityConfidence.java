/*
 * Copyright 2021 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.pmml.commons.model.tuples;

/**
 * Class to represent a <b>probability/confidence</b> tuple
 */
public class KiePMMLProbabilityConfidence {

    private final double probability;
    private final double confidence;

    public KiePMMLProbabilityConfidence(double probability, double confidence) {
        this.probability = probability;
        this.confidence = confidence;
    }

    public double getProbability() {
        return probability;
    }

    public double getConfidence() {
        return confidence;
    }
}