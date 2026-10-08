/* SPDX-License-Identifier: MIT */

package io.github.tomarkar.workbench;

import atlantafx.base.theme.Theme;

/**
 * A dark AtlantaFX theme based on the IntelliJ Dark (Darcula) color palette
 * of the Familiar Java Themes project.
 */
public final class WorkbenchDark implements Theme {

    public WorkbenchDark() {
        // Default constructor
    }

    @Override
    public String getName() {
        return "Workbench Dark";
    }

    @Override
    public String getUserAgentStylesheet() {
        return "/io/github/tomarkar/workbench/workbench-dark.css";
    }

    @Override
    public String getUserAgentStylesheetBSS() {
        // no binary stylesheet is shipped for this theme
        return null;
    }

    @Override
    public boolean isDarkMode() {
        return true;
    }
}
