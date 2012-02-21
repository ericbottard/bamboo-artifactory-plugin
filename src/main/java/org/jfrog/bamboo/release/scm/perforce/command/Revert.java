/*
 * Copyright (C) 2012 JFrog Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jfrog.bamboo.release.scm.perforce.command;

import com.tek42.perforce.Depot;
import com.tek42.perforce.PerforceException;
import com.tek42.perforce.parse.AbstractPerforceTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Revert the local changes.
 *
 * @author Yossi Shaul
 * @see <a href="http://www.perforce.com/perforce/doc.current/manuals/cmdref/revert.html">http://www.perforce.com/perforce/doc.current/manuals/cmdref/revert.html</a>
 */
public class Revert extends AbstractPerforceTemplate {
    private static Logger debuggingLogger = Logger.getLogger(Revert.class.getName());

    private final Depot depot;

    public Revert(Depot depot) {
        super(depot);
        this.depot = depot;
    }

    /**
     * Revert the default change set.
     */
    public void revert() throws PerforceException {
        debuggingLogger.log(Level.FINE, "Reverting default changelist");
        String p4Exec = depot.getExecutable();
        getPerforceResponse(new String[]{p4Exec, "-s", "revert", "-c", "default", "//..."});
    }
}