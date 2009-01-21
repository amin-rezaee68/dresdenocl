/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.node;

import org.sablecc.sablecc.analysis.*;
import org.sablecc.sablecc.node.Switch;
import org.sablecc.sablecc.node.TId;
import org.sablecc.sablecc.node.Token;



public final class TId extends Token
{
    public TId(String text)
    {
        setText(text);
    }

    public TId(String text, int line, int pos)
    {
        setText(text);
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TId(getText(), getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTId(this);
    }
}