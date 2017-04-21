/*
 * SonarQube .NET Tests Library
 * Copyright (C) 2014-2017 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.plugins.dotnet.tests;

public class CoverageConfiguration {

  private final String languageKey;
  private final String ncover3PropertyKey;
  private final String openCoverPropertyKey;
  private final String dotCoverPropertyKey;
  private final String visualStudioCoverageXmlPropertyKey;

  public CoverageConfiguration(String languageKey, String ncover3PropertyKey, String openCoverPropertyKey, String dotCoverPropertyKey, String visualStudioCoverageXmlPropertyKey) {
    this.languageKey = languageKey;
    this.ncover3PropertyKey = ncover3PropertyKey;
    this.openCoverPropertyKey = openCoverPropertyKey;
    this.dotCoverPropertyKey = dotCoverPropertyKey;
    this.visualStudioCoverageXmlPropertyKey = visualStudioCoverageXmlPropertyKey;
  }

  String languageKey() {
    return languageKey;
  }

  String ncover3PropertyKey() {
    return ncover3PropertyKey;
  }

  String openCoverPropertyKey() {
    return openCoverPropertyKey;
  }

  String dotCoverPropertyKey() {
    return dotCoverPropertyKey;
  }

  String visualStudioCoverageXmlPropertyKey() {
    return visualStudioCoverageXmlPropertyKey;
  }

}