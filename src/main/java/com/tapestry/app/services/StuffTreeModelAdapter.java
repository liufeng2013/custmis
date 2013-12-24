package com.tapestry.app.services;

import java.util.List;

import org.apache.tapestry5.tree.TreeModelAdapter;

import com.tapestry.app.entities.Stuff;

public class StuffTreeModelAdapter implements TreeModelAdapter<Stuff> {

	public boolean isLeaf(Stuff stuff) {
		return !hasChildren(stuff);
	}

	public boolean hasChildren(Stuff stuff) {
		return stuff.children != null && !stuff.children.isEmpty();
	}

	public List<Stuff> getChildren(Stuff stuff) {
		return stuff.children;
	}

	public String getLabel(Stuff stuff) {
		return stuff.name;
	}

}
