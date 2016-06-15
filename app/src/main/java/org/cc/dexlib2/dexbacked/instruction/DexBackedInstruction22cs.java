/*
 * Copyright 2013, Google Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.cc.dexlib2.dexbacked.instruction;

import org.cc.dexlib2.Opcode;
import org.cc.dexlib2.dexbacked.DexBackedDexFile;
import org.cc.dexlib2.iface.instruction.formats.Instruction22cs;
import org.cc.util.NibbleUtils;

import javax.annotation.Nonnull;

public class DexBackedInstruction22cs extends DexBackedInstruction implements Instruction22cs {
    public DexBackedInstruction22cs(@Nonnull DexBackedDexFile dexFile,
                                    @Nonnull Opcode opcode,
                                    int instructionStart) {
        super(dexFile, opcode, instructionStart);
    }

    @Override
    public int getRegisterA() {
        return NibbleUtils.extractLowUnsignedNibble(dexFile.readByte(instructionStart + 1));
    }

    @Override
    public int getRegisterB() {
        return NibbleUtils.extractHighUnsignedNibble(dexFile.readByte(instructionStart + 1));
    }

    @Override
    public int getFieldOffset() {
        return dexFile.readUshort(instructionStart + 2);
    }
}
