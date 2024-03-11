package com.kpabr.deepercaves;

public class DeeperLevel {
    public String name;
    public DeeperLevel prev;
    public DeeperLevel next;

    public DeeperLevel(String name)
    {
        this(name, null, null);
    }

    public DeeperLevel(String name, DeeperLevel prev)
    {
        this(name, prev, null);
    }

    public DeeperLevel(String name, DeeperLevel prev, DeeperLevel next)
    {
        this.name = name;
        this.prev = prev;
        if(this.prev != null)
        {
            this.prev.next = this;
        }
        this.next = next;
        if(this.next != null)
        {
            this.next.prev = this;
        }
        DeeperCaves.levels.put("deepercaves:"+this.name, this);
    }
}
