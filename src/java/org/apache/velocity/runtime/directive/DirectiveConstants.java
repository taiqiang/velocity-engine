package org.apache.velocity.runtime.directive;

/*
 * Copyright 2000-2004 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
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

/**
 *  Base class for all directives used in Velocity.
 *
 *  @version $Id: DirectiveConstants.java,v 1.5 2004/02/27 18:43:15 dlr Exp $ 
 */
public interface DirectiveConstants
{
    /** Block directive indicator */
    public static final int BLOCK = 1;
    
    /** Line directive indicator */
    public static final int LINE = 2;
}        
