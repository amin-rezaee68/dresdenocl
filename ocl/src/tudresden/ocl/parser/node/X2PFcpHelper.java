/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import tudresden.ocl.parser.analysis.*;

public final class X2PFcpHelper extends XPFcpHelper
{
    private PFcpHelper _pFcpHelper_;

    public X2PFcpHelper()
    {
    }

    public X2PFcpHelper(
        PFcpHelper _pFcpHelper_)
    {
        setPFcpHelper(_pFcpHelper_);
    }

    public Object clone()
    {
        throw new RuntimeException("Unsupported Operation");
    }

    public void apply(Switch sw)
    {
        throw new RuntimeException("Switch not supported.");
    }

    public PFcpHelper getPFcpHelper()
    {
        return _pFcpHelper_;
    }

    public void setPFcpHelper(PFcpHelper node)
    {
        if(_pFcpHelper_ != null)
        {
            _pFcpHelper_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _pFcpHelper_ = node;
    }

    void removeChild(Node child)
    {
        if(_pFcpHelper_ == child)
        {
            _pFcpHelper_ = null;
        }
    }

    void replaceChild(Node oldChild, Node newChild)
    {
    }

    public String toString()
    {
        return "" +
            toString(_pFcpHelper_);
    }
}

