def slack(String buildStatus, String channel) {
    // build status of null means successful
    buildStatus =  buildStatus ?: 'SUCCESS'
    
    // Default values
    def colorName = 'RED'
    def colorCode = '#FF0000'
    def summary = "${env.JOB_NAME} - ${currentBuild.displayName} ${currentBuild.currentResult} after " +
                                  "${currentBuild.durationString.replace(' and counting', '')} " +
                                  "(<${currentBuild.absoluteUrl}|Open>)"
    
    // Override default values based on build status
    if (buildStatus == 'SUCCESS') {
        color = 'GREEN'
        colorCode = '#00FF00'
    } else {
        color = 'RED'
        colorCode = '#FF0000'
    }
    
    // Send notifications
    slackSend (channel: channel,color: colorCode, message: summary)
}
