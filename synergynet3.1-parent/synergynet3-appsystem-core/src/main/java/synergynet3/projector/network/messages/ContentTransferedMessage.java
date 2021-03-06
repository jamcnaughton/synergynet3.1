package synergynet3.projector.network.messages;

import java.io.Serializable;

import synergynet3.databasemanagement.GalleryItemDatabaseFormat;
import synergynet3.web.shared.messages.PerformActionMessage;

/**
 * Structured message representing the item, its target and trajectory when
 * transferred through a network flick.
 */
public class ContentTransferedMessage extends PerformActionMessage implements Serializable, Comparable<ContentTransferedMessage>
{

	/** Unique ID for serialisation. */
	private static final long serialVersionUID = 3301043234796641222L;

	/**
	 * Object representing the flicked item and its attached feedback stored in
	 * a serialisable form.
	 */
	private GalleryItemDatabaseFormat galleryItem;

	/** Name of the item being transferred. */
	private String itemName;

	/** Rotation of the transferred item on arrival. */
	private float rotation;

	/** Scale of the transferred item on arrival. */
	private float scale;

	/** Cluster ID of the target devices. */
	private String[] targetDeviceIDs;

	/** Visibility of the item being transferred. */
	private boolean visible;

	/** The arrival location of the transferred item. */
	private float x, y;

	/** The z level of the item. */
	private int zOrder;

	/**
	 * Empty Constructor used to initialise value in the network cluster.
	 */
	public ContentTransferedMessage()
	{
		super();
	}

	/**
	 * Create a structured network flick message for transmission through the
	 * cluster.
	 *
	 * @param targetDeviceIDs
	 *            List of target table's identity in the cluster.
	 * @param galleryItem
	 *            Object representing the transfered item and its attached
	 *            feedback.
	 * @param x
	 *            The X value of the transfered item's arrival location.
	 * @param y
	 *            The Y value of the transfered item's arrival location.
	 * @param targetAngle
	 *            Rotation of the transfered item on arrival.
	 * @param targetScale
	 *            Scale of the transfered item on arrival. *
	 * @param zOrder
	 *            the zOrder ID of the transfered item.
	 * @param Visibility
	 *            of the item being transferred.
	 * @param itemName
	 *            the unique ID of the transfered item.
	 */
	public ContentTransferedMessage(String[] targetDeviceIDs, GalleryItemDatabaseFormat galleryItem, float x, float y, float targetAngle, float targetScale, int zOrder, boolean visible, String itemName)
	{
		super(MESSAGESTATE.ACTIVATE);
		this.targetDeviceIDs = targetDeviceIDs;
		this.galleryItem = galleryItem;
		this.x = x;
		this.y = y;
		this.rotation = targetAngle;
		this.scale = targetScale;
		this.zOrder = zOrder;
		this.visible = visible;
		this.itemName = itemName;
	}

	/**
	 * Allows sorting of items by their Z-Orders.
	 *
	 * @param other
	 *            Another instance of ContentTransferedMessage.
	 */
	@Override
	public int compareTo(ContentTransferedMessage other)
	{
		int toReturn = 0;
		if (this.zOrder > other.getZOrder())
		{
			toReturn = 1;
		}
		else if (this.zOrder < other.getZOrder())
		{
			toReturn = -1;
		}
		return toReturn;
	}

	/**
	 * Get the object representing the transfered item and its attached
	 * feedback.
	 *
	 * @return Object representing the transfered item and its attached
	 *         feedback.
	 */
	public GalleryItemDatabaseFormat getGalleryItem()
	{
		return galleryItem;
	}

	/**
	 * Get the item name.
	 *
	 * @return String representing the transfered item's name.
	 */
	public String getItemName()
	{
		return itemName;
	}

	/**
	 * Get the rotation of the transfered item on arrival.
	 *
	 * @return The rotation of the transfered item on arrival.
	 */
	public float getRotation()
	{
		return rotation;
	}

	/**
	 * Get the scale of the transfered item on arrival.
	 *
	 * @return The scale of the transfered item on arrival.
	 */
	public float getScale()
	{
		return scale;
	}

	/**
	 * Get the target device's IDs in the cluster.
	 *
	 * @return String representing the target devices' IDs
	 */
	public String[] getTargetDeviceIDs()
	{
		return targetDeviceIDs;
	}

	/**
	 * Get the X value of the transfered item's arrival location.
	 *
	 * @return The X value of the transfered item's arrival location.
	 */
	public float getX()
	{
		return x;
	}

	/**
	 * Get the Y value of the transfered item's arrival location.
	 *
	 * @return The Y value of the transfered item's arrival location.
	 */
	public float getY()
	{
		return y;
	}

	/**
	 * Get the transfered item's z level.
	 *
	 * @return String representing Z level of the transfered item.
	 */
	public int getZOrder()
	{
		return zOrder;
	}

	/**
	 * @return the visible
	 */
	public boolean isVisible()
	{
		return visible;
	}

	/**
	 * Set the object representing the transfered item and its attached
	 * feedback.
	 *
	 * @param galleryItem
	 *            Object representing the transfered item and its attached
	 *            feedback.
	 */
	public void setGalleryItem(GalleryItemDatabaseFormat galleryItem)
	{
		this.galleryItem = galleryItem;
	}

	/**
	 * Set the item name.
	 *
	 * @param itemName
	 *            Name of the item.
	 */
	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}

	/**
	 * Set the rotation of the transfered item on arrival.
	 *
	 * @param rotation
	 *            The rotation of the transfered item on arrival.
	 */
	public void setRotation(float rotation)
	{
		this.rotation = rotation;
	}

	/**
	 * Set the scale of the transfered item on arrival.
	 *
	 * @param scale
	 *            The scale of the transfered item on arrival.
	 */
	public void setScale(float scale)
	{
		this.scale = scale;
	}

	/**
	 * Set the target device's IDs in the cluster.
	 *
	 * @param targetDeviceIDs
	 *            The target devices' IDs
	 */
	public void setTargetDeviceIDs(String[] targetDeviceIDs)
	{
		this.targetDeviceIDs = targetDeviceIDs;
	}

	/**
	 * @param visible
	 *            the visible to set
	 */
	public void setVisible(boolean visible)
	{
		this.visible = visible;
	}

	/**
	 * Set the X value of the transfered item's arrival location.
	 *
	 * @param x
	 *            The X value of the transfered item's arrival location.
	 */
	public void setX(float x)
	{
		this.x = x;
	}

	/**
	 * Set the Y value of the transfered item's arrival location.
	 *
	 * @param y
	 *            The Y value of the transfered item's arrival location.
	 */
	public void setY(float y)
	{
		this.y = y;
	}

	/**
	 * Set the transfered item's z level.
	 *
	 * @param sourceID
	 *            Z level of the transfered item.
	 */
	public void setZOrder(int zOrder)
	{
		this.zOrder = zOrder;
	}

}
