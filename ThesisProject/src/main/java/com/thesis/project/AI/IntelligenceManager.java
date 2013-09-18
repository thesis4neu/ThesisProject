/*
 *  Revision History:
 *
 *  DATE/AUTHOR         COMMENT
 *  ---------------------------------------------------------------------
 *  Sep 17, 2013/Forsakendoll                                                      
 */
package com.thesis.project.AI;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;

/**
 * TODO:Write class description
 *
 * @author [[mailto:'jrp.mantaring@gmail.com']['James Rod P. Mantaring']]
 */
public class IntelligenceManager
{
    /**
     * @param rulesFile Drools rule file
     * @return rules
     * @throws Exception
     */
    public KnowledgeBase readKnowledgeBase( String rulesFile ) throws Exception
    {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add( ResourceFactory.newClassPathResource( rulesFile ), ResourceType.DRL );
        KnowledgeBuilderErrors errors = kbuilder.getErrors();
        if( errors.size() > 0 )
        {
            for( KnowledgeBuilderError error : errors )
            {
                System.err.println( error );
            }
            throw new IllegalArgumentException( "Could not parse knowledge." );
        }
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages( kbuilder.getKnowledgePackages() );
        return kbase;
    }
}
