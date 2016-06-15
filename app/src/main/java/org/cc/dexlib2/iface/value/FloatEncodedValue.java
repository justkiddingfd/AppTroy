/*
 * Copyright 2012, Google Inc.
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

package org.cc.dexlib2.iface.value;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * This class represents an encoded float value.
 */
public interface FloatEncodedValue extends EncodedValue {
    /**
     * Gets the float value.
     *
     * @return the float value
     */
    float getValue();

    /**
     * Returns a hashcode for this EncodedFloatValue.
     *
     * This hashCode is defined to be the following:
     *
     * <pre>
     * {@code
     * int hashCode = Float.floatToRawIntBits(getValue());
     * }</pre>
     *
     * Note: This is slightly different than the definition of Float.hashCode(). This uses floatToRawIntBits()
     * instead of floatToIntBits(), in order to preserve as much information as possible.
     *
     * @return The hash code value for this EncodedFloatValue
     */
    @Override int hashCode();

    /**
     * Compares this FloatEncodedValue to another FloatEncodedValue for equality.
     *
     * This FloatEncodedValue is equal to another FloatEncodedValue if the values returned by
     * getValue().floatToRawIntBits() are equal.
     *
     * Note: this isn't quite the same as getValue() == getValue(), due to various NaN issues and signed zero issues.
     *
     * @param o The object to be compared for equality with this FloatEncodedValue
     * @return true if the specified object is equal to this FloatEncodedValue
     */
    @Override boolean equals(@Nullable Object o);

    /**
     * Compare this FloatEncodedValue to another EncodedValue.
     *
     * The comparison is first done on the return values of getValueType(). If the other value is another
     * FloatEncodedValue, the return values of getValue() are compared, using the semantics of Float.compare()
     *
     * @param o The EncodedValue to compare with this FloatEncodedValue
     * @return An integer representing the result of the comparison
     */
    @Override int compareTo(@Nonnull EncodedValue o);
}
