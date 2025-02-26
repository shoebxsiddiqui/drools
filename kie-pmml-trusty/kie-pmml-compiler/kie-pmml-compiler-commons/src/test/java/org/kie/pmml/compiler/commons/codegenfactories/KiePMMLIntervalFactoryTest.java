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

package org.kie.pmml.compiler.commons.codegenfactories;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.Statement;
import org.dmg.pmml.Interval;
import org.junit.Test;
import org.kie.pmml.api.enums.CLOSURE;
import org.kie.pmml.commons.model.expressions.KiePMMLInterval;
import org.kie.pmml.compiler.commons.utils.JavaParserUtils;

import static org.junit.Assert.assertTrue;
import static org.kie.pmml.compiler.commons.testutils.CodegenTestUtils.commonValidateCompilationWithImports;

public class KiePMMLIntervalFactoryTest {

    @Test
    public void getIntervalVariableDeclaration() {
        String variableName = "variableName";
        double leftMargin = 45.32;

        Interval interval = new Interval();
        interval.setLeftMargin(leftMargin);
        interval.setRightMargin(null);
        interval.setClosure(Interval.Closure.CLOSED_OPEN);

        BlockStmt retrieved = KiePMMLIntervalFactory.getIntervalVariableDeclaration(variableName,
                                                                                    interval);
        String closureString =
                CLOSURE.class.getName() + "." + CLOSURE.byName(interval.getClosure().value()).name();

        Statement expected = JavaParserUtils.parseBlock(String.format("{\n" +
                                                                              "    KiePMMLInterval " +
                                                                              "%s = new " +
                                                                              "KiePMMLInterval(%s, " +
                                                                              "null, " +
                                                                              "%s);\n" +
                                                                              "}", variableName, leftMargin, closureString));
        assertTrue(JavaParserUtils.equalsNode(expected, retrieved));
        List<Class<?>> imports = Arrays.asList(Collections.class, KiePMMLInterval.class);
        commonValidateCompilationWithImports(retrieved, imports);
    }

}