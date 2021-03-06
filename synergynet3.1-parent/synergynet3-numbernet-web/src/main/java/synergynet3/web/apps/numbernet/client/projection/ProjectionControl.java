package synergynet3.web.apps.numbernet.client.projection;

import java.util.ArrayList;
import java.util.List;

import synergynet3.web.commons.client.dialogs.MessageDialogBox;
import synergynet3.web.commons.client.service.SynergyNetWebCommonsService;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * The Class ProjectionControl.
 */
public class ProjectionControl extends VerticalPanel
{

	/** The control panels. */
	private VerticalPanel controlPanels;

	/**
	 * Instantiates a new projection control.
	 */
	public ProjectionControl()
	{
		controlPanels = new VerticalPanel();
		setTitle("Projection Control");

		Button btnDiscover = new Button("Discover");
		btnDiscover.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				loadProjectionControlPanels();
			}
		});
		add(btnDiscover);
		add(controlPanels);
	}

	/**
	 * Gets the currently known projectors.
	 *
	 * @return the currently known projectors
	 */
	private List<String> getCurrentlyKnownProjectors()
	{
		List<String> currentlyKnownProjectors = new ArrayList<String>();
		for (int i = 0; i < controlPanels.getWidgetCount(); i++)
		{
			ProjectionControlPanel pcp = (ProjectionControlPanel) controlPanels.getWidget(i);
			currentlyKnownProjectors.add(pcp.getProjectorName());
		}
		return currentlyKnownProjectors;
	}

	/**
	 * Adds the control panels for names.
	 *
	 * @param newProjectors
	 *            the new projectors
	 */
	protected void addControlPanelsForNames(List<String> newProjectors)
	{
		for (String np : newProjectors)
		{
			ProjectionControlPanel pcp = new ProjectionControlPanel();
			pcp.setProjectorName(np);
			controlPanels.add(pcp);
		}

	}

	/**
	 * Load projection control panels.
	 */
	protected void loadProjectionControlPanels()
	{
		SynergyNetWebCommonsService.Util.getInstance().getDevicesCurrentlyOnline("projectors", new AsyncCallback<List<String>>()
		{

			@Override
			public void onFailure(Throwable caught)
			{
				new MessageDialogBox(caught.getMessage()).show();
			}

			@Override
			public void onSuccess(List<String> result)
			{
				System.out.println(result);
				List<String> currentlyKnownProjectors = getCurrentlyKnownProjectors();
				List<String> projectorsGone = getCurrentlyKnownProjectors();

				for (String op : result)
				{
					projectorsGone.remove(op);
				}

				List<String> newProjectors = new ArrayList<String>();
				for (String n : result)
				{
					if (!currentlyKnownProjectors.contains(n))
					{
						newProjectors.add(n);
					}
				}

				removeControlPanelsForNames(projectorsGone);
				addControlPanelsForNames(newProjectors);

			}
		});

	}

	/**
	 * Removes the control panels for names.
	 *
	 * @param projectorsGone
	 *            the projectors gone
	 */
	protected void removeControlPanelsForNames(List<String> projectorsGone)
	{
		for (int i = 0; i < controlPanels.getWidgetCount(); i++)
		{
			ProjectionControlPanel pcp = (ProjectionControlPanel) controlPanels.getWidget(i);
			if (projectorsGone.contains(pcp.getProjectorName()))
			{
				controlPanels.remove(pcp);
			}
		}
	}

}
