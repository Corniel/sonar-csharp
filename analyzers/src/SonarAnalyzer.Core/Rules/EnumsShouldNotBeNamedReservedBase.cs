/*
 * SonarAnalyzer for .NET
 * Copyright (C) 2014-2025 SonarSource SA
 * mailto:info AT sonarsource DOT com
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the Sonar Source-Available License Version 1, as published by SonarSource SA.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the Sonar Source-Available License for more details.
 *
 * You should have received a copy of the Sonar Source-Available License
 * along with this program; if not, see https://sonarsource.com/license/ssal/
 */

using SonarAnalyzer.CFG.Extensions;

namespace SonarAnalyzer.Core.Rules;

public abstract class EnumsShouldNotBeNamedReservedBase<TSyntaxKind> : SonarDiagnosticAnalyzer<TSyntaxKind>
        where TSyntaxKind : struct
{
    internal const string DiagnosticId = "S4016";

    protected override string MessageFormat => "Remove or rename this enum member.";

    protected EnumsShouldNotBeNamedReservedBase() : base(DiagnosticId) { }

    protected override void Initialize(SonarAnalysisContext context) =>
        context.RegisterNodeAction(
            Language.GeneratedCodeRecognizer,
            c =>
            {
                if (Language.Syntax.NodeIdentifier(c.Node) is { } enumMemberDeclaration
                    && enumMemberDeclaration.ValueText
                        .SplitCamelCaseToWords()
                        .Any(w => w == "RESERVED"))
                {
                    c.ReportIssue(Rule, enumMemberDeclaration);
                }
            },
            Language.SyntaxKind.EnumMemberDeclaration);
}
