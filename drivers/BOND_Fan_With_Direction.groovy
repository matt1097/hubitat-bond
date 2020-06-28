/**
 *  BOND Fan With Direction
 *
 *  Copyright 2019-2020 Dominick Meglio
 *
 */

metadata {
    definition (
		name: "BOND Fan With Direction", 
		namespace: "bond", 
		author: "dmeglio@gmail.com",
		importUrl: "https://raw.githubusercontent.com/dcmeglio/hubitat-bond/master/drivers/BOND_Fan_With_Direction.groovy"
	) {
		capability "Switch"
        capability "FanControl"
		command "setDirection", [[name:"Direction", type: "ENUM", description: "Direction", constraints: ["forward","reverse"] ] ]
		attribute "direction", "enum", ["forward", "reverse"]
		
		command "fixPower", [[name:"Power*", type: "ENUM", description: "Power", constraints: ["off","on"] ] ]
		command "fixSpeed", [[name:"Speed*", type: "ENUM", description: "Speed", constraints: ["off","low", "medium-low", "medium", "medium-high", "high", "on"] ] ]
		command "fixDirection", [[name:"Direction*", type: "ENUM", description: "Direction", constraints: ["forward","reverse"] ] ]
		command "toggle"
    }
}

def on() {
	parent.handleOn(device)
	if (state.lastSpeed != null)
	{
		parent.handleFanSpeed(device, state.lastSpeed)
	}
}

def off() {
	parent.handleOff(device)
}

def toggle() {
	if (device.currentValue("switch") == "on")
		off()
	else
		on()
}

def handleLightOn(device, id) {
    parent.handleLightOn(device, id)
}

def handleLightOff(device, id) {
    parent.handleLightOff(device, id)
}

def setSpeed(speed) {
	if (speed != "off" && speed != "on")
		state.lastSpeed = speed
    parent.handleFanSpeed(device, speed)
}

def setDirection(direction) {
	parent.handleDirection(device, direction)
}

def handleLightLevel(device, id, level)
{
	parent.handleLightLevel(device, id, level)
}

def handleDim(device, bondId, duration) {
	parent.handleDim(device, bondId, duration)
}

def handleStartDimming(device, bondId) {
	parent.handleStartDimming(device, bondId)
}

def handleStopDimming(device, bondId) {
	parent.handleStopDimming(device, bondId)
}

def fixPower(power) {
	parent.fixPowerState(device, power)
}

def fixSpeed(speed) {
	parent.fixFanSpeed(device, speed)
}

def fixDirection(direction) {
	parent.fixDirection(device, direction)
}

def fixLightPower(device, bondId, power) {
	parent.fixLightPower(device, bondId, power)
}

def fixLightLevel(device, bondId, level) {
	parent.fixLightLevel(device, bondId, level)
}