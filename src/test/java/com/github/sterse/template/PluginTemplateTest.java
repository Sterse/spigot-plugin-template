/**
 * <one line to give the program's name and a brief idea of what it does.>
 * Copyright (C) <year>  <name of author>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.github.sterse.template;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PluginTemplateTest {

    @Mock
    private Logger logger;

    @Mock
    private PluginTemplate plugin;

    @Test
    void testOnLoad() {
        doCallRealMethod().when(plugin).onLoad();
        try (var mockedLogManager = mockStatic(LogManager.class)) {
            mockedLogManager.when(LogManager::getLogger).thenReturn(logger);
            plugin.onLoad();
        }
        verify(logger, only()).info("Loaded");
    }

    @Test
    void testOnEnable() {
        doCallRealMethod().when(plugin).onEnable();
        try (var mockedLogManager = mockStatic(LogManager.class)) {
            mockedLogManager.when(LogManager::getLogger).thenReturn(logger);
            plugin.onEnable();
        }
        verify(logger, only()).info("Enabled");
    }

    @Test
    void testOnDisable() {
        doCallRealMethod().when(plugin).onDisable();
        try (var mockedLogManager = mockStatic(LogManager.class)) {
            mockedLogManager.when(LogManager::getLogger).thenReturn(logger);
            plugin.onDisable();
        }
        verify(logger, only()).info("Disabled");
    }

}
