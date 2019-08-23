package com.adobe.aem.guides.wknd.core.listeners;

import java.util.List;

import org.apache.sling.api.resource.observation.ResourceChange;
import org.apache.sling.api.resource.observation.ResourceChangeListener;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Sling Resource Change Listener is the preferred method for listening for Resource Change events in AEM.
 * This is preferred over the Sling Resource Event Listener, or the JCR Event Handler approaches.
 *
 * ResourceChangeListener Javadoc:
 *  - https://docs.adobe.com/docs/en/aem/6-2/develop/ref/javadoc/org/apache/sling/api/resource/observation/ResourceChangeListener.html
 *
 * Note: To listen for External events, implements the ExternalResourceChangeListener. If ONLY local events are in scope, implement only the ResourceChangeListener.
 */


@Component(service = ResourceChangeListener.class, 
           immediate = true, 
           property = {
		     Constants.SERVICE_DESCRIPTION + "=Resource change listener",
		     "ResourceChangeListener.PATHS={/content,wknd}"
           })
public class SampleResourceChangeListener implements ResourceChangeListener {
    private static final Logger log = LoggerFactory.getLogger(SampleResourceChangeListener.class);


    public void onChange(List<ResourceChange> changes) {
        // Iterate over the ResourceChanges and process them

        for (final ResourceChange change : changes) {
            // Process each change quickly; Do not do long-running work in the Resource Change Listener.
            // If expensive/long-running work is required to handle the event, create a Sling Job to perform that work.

            switch (change.getType()) {
                case ADDED:
                    log.debug("Change Type ADDED: {}", change);
                    break;
                case CHANGED:
                    log.debug("Change Type CHANGED: {}", change);
                    break;
                case REMOVED:
                    log.debug("Change Type REMOVED: {}", change);
                    // etc.
                    break;
                case PROVIDER_ADDED:
                    log.debug("Change Type PROVIDER_ADDED: {}", change);
                    // etc.
                    break;
                case PROVIDER_REMOVED:
                    log.debug("Change Type PROVIDER_REMOVED: {}", change);
                    // etc.
                    break;
                default:
                    // Do nothing
            }
        }
    }
}
