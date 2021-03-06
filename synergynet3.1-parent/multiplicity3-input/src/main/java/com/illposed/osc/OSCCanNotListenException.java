/*
 * Copyright (c) 2002-2006, C. Ramakrishnan / Illposed Software All rights
 * reserved. Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met: *
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer. * Redistributions in binary
 * form must reproduce the above copyright notice, this list of conditions and
 * the following disclaimer in the documentation and/or other materials provided
 * with the distribution. * Neither the name of the Illposed Software nor the
 * names of its contributors may be used to endorse or promote products derived
 * from this software without specific prior written permission. THIS SOFTWARE
 * IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS
 * OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO
 * EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/*
 * $Id: OSCCanNotListenException.java,v 1.1 2010/05/06 14:59:51 dcs0ah1 Exp $
 * Created on 21.02.2004
 */
package com.illposed.osc;

/**
 * @author cramakrishnan Copyright (C) 2004, C. Ramakrishnan / Auracle All
 *         rights reserved. See license.txt (or license.rtf) for license
 *         information.
 */
public class OSCCanNotListenException extends Exception
{

	/**
	 *
	 */
	private static final long serialVersionUID = -932015208334917542L;

	/**
	 *
	 */
	public OSCCanNotListenException()
	{
		super();
	}

	/**
	 * @param message
	 */
	public OSCCanNotListenException(String message)
	{
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	/*
	 * public OSCCanNotListenException(String message, Throwable cause) {
	 * super(message, cause); }
	 */
	/**
	 * @param cause
	 */
	/*
	 * public OSCCanNotListenException(Throwable cause) { super(cause); }
	 */
}
