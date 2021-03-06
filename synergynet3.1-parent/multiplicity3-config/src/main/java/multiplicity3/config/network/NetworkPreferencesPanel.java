/*
 * NetworkPrefsPanel2.java Created on September 23, 2010, 3:21 PM
 */

package multiplicity3.config.network;

import java.awt.Rectangle;

import javax.swing.JOptionPane;

/**
 * @author dcs0ah1
 */
public class NetworkPreferencesPanel extends javax.swing.JPanel
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7749882192186771339L;

	/** The check proxy enabled. */
	private javax.swing.JCheckBox checkProxyEnabled;

	/** The j label1. */
	private javax.swing.JLabel jLabel1;

	/** The j label2. */
	private javax.swing.JLabel jLabel2;

	/** The prefs. */
	private NetworkConfigPrefsItem prefs;

	/** The txt proxy host. */
	private javax.swing.JTextField txtProxyHost;

	/** The txt proxy port. */
	private javax.swing.JTextField txtProxyPort;

	/** Creates new form NetworkPrefsPanel2 */
	public NetworkPreferencesPanel(NetworkConfigPrefsItem networkConfigPrefsItem)
	{
		this.prefs = networkConfigPrefsItem;
		initComponents();
		loadPrefs();
	}

	/**
	 * Check proxy enabled item state changed.
	 *
	 * @param evt
	 *            the evt
	 */
	private void checkProxyEnabledItemStateChanged(java.awt.event.ItemEvent evt)
	{// GEN-FIRST:event_checkProxyEnabledItemStateChanged

		prefs.setProxyEnabled(checkProxyEnabled.isSelected());
	}// GEN-LAST:event_checkProxyEnabledItemStateChanged

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// @SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents()
	{

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		txtProxyHost = new javax.swing.JTextField();
		txtProxyPort = new javax.swing.JTextField();
		checkProxyEnabled = new javax.swing.JCheckBox();

		jLabel1.setText("HTTP Proxy Host:");

		jLabel2.setText("HTTP Proxy Port:");

		txtProxyHost.setText("jTextField1");
		txtProxyHost.addKeyListener(new java.awt.event.KeyAdapter()
		{
			@Override
			public void keyReleased(java.awt.event.KeyEvent evt)
			{
				txtProxyHostKeyReleased(evt);
			}
		});

		txtProxyPort.setText("jTextField1");
		txtProxyPort.addKeyListener(new java.awt.event.KeyAdapter()
		{
			@Override
			public void keyReleased(java.awt.event.KeyEvent evt)
			{
				txtProxyPortKeyReleased(evt);
			}
		});

		checkProxyEnabled.setText("Proxy Enabled");
		checkProxyEnabled.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
		checkProxyEnabled.addItemListener(new java.awt.event.ItemListener()
		{
			@Override
			public void itemStateChanged(java.awt.event.ItemEvent evt)
			{
				checkProxyEnabledItemStateChanged(evt);
			}
		});

		setLayout(null);

		jLabel1.setBounds(new Rectangle(30, 30, 200, 24));
		txtProxyHost.setBounds(new Rectangle(160, 30, 200, 24));

		jLabel2.setBounds(new Rectangle(30, 60, 200, 24));
		txtProxyPort.setBounds(new Rectangle(160, 60, 50, 24));

		checkProxyEnabled.setBounds(new Rectangle(25, 90, 200, 24));

		add(jLabel1);
		add(txtProxyHost);
		add(jLabel2);
		add(txtProxyPort);
		add(checkProxyEnabled);

	}// </editor-fold>//GEN-END:initComponents

	/**
	 * Load prefs.
	 */
	private void loadPrefs()
	{
		txtProxyHost.setText(prefs.getProxyHost());
		txtProxyPort.setText("" + prefs.getProxyPort());
		checkProxyEnabled.setSelected(prefs.getProxyEnabled());
	}

	/**
	 * Txt proxy host key released.
	 *
	 * @param evt
	 *            the evt
	 */
	private void txtProxyHostKeyReleased(java.awt.event.KeyEvent evt)
	{// GEN-FIRST:event_txtProxyHostKeyReleased
		prefs.setProxyHost(txtProxyHost.getText());
	}// GEN-LAST:event_txtProxyHostKeyReleased

	/**
	 * Txt proxy port key released.
	 *
	 * @param evt
	 *            the evt
	 */
	private void txtProxyPortKeyReleased(java.awt.event.KeyEvent evt)
	{// GEN-FIRST:event_txtProxyPortKeyReleased
		int currentPort = prefs.getProxyPort();
		try
		{
			prefs.setProxyPort(Integer.parseInt(txtProxyPort.getText()));
		}
		catch (NumberFormatException ex)
		{
			JOptionPane.showMessageDialog(this, "Can't convert " + txtProxyPort.getText() + " to a number.", "Port should be an integer number.", JOptionPane.ERROR_MESSAGE);
			txtProxyPort.setText("" + currentPort);
		}
	}// GEN-LAST:event_txtProxyPortKeyReleased

}
