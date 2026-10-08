/* SPDX-License-Identifier: MIT */

package io.github.tomarkar.workbench;

import atlantafx.base.theme.Theme;

/**
 * A light AtlantaFX theme based on the IntelliJ Light color palette
 * of the Familiar Java Themes project.
 */
public final class WorkbenchLight implements Theme {

    public WorkbenchLight() {
        // Default constructor
    }

    @Override
    public String getName() {
        return "Workbench Light";
    }

    @Override
    public String getUserAgentStylesheet() {
        return "/io/github/tomarkar/workbench/workbench-light.css";
    }

    @Override
    public String getUserAgentStylesheetBSS() {
        // no binary stylesheet is shipped for this theme
        return null;
    }

    @Override
    public boolean isDarkMode() {
        return false;
    }
}
