package com.tapestry.app.pages.tree;

import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.corelib.components.Tree;
import org.apache.tapestry5.tree.DefaultTreeModel;
import org.apache.tapestry5.tree.TreeModel;

import com.tapestry.app.entities.Stuff;
import com.tapestry.app.services.StuffTreeModelAdapter;

public class TreeBrowse {

	// Screen fields
	private TreeModel<Stuff> stuffModel;
	// Generally useful bits and pieces
	@InjectComponent
	private Tree tree;

	// The code
	void onClearExpansions() {
		tree.clearExpansions();
	}

	// Getters and setters
	public TreeModel<Stuff> getStuffModel() {
		if (stuffModel == null) {
			ValueEncoder<Stuff> stuffEncoder = new ValueEncoder<Stuff>() {
				public String toClient(Stuff stuff) {
					return stuff.uuid;
				}

				public Stuff toValue(String uuid) {
					return Stuff.ROOT.searchSubTree(uuid);
				}
			};
			stuffModel = new DefaultTreeModel<Stuff>(stuffEncoder,
					new StuffTreeModelAdapter(), Stuff.ROOT.children);
		}
		return stuffModel;
	}
}
