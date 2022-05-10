package model;

import java.util.Arrays;

public class HDDPlaningAccess {
	
	public int FCFS(int[] requests, int pos) {
		int ref = pos;
		int distance = 0;
		for(int i=0; i<requests.length; i++) {
			distance+= Math.abs(ref-requests[i]);
			ref = requests[i];
		}
		return distance;
	}
	
	public int SCAN(int[] requests, int pos, int max, int min, boolean directionUp) {
		int distance = 0;
		int ref = pos;
		Arrays.sort(requests);
		
		distance = requests[requests.length-1] - requests[0];
		
		if(directionUp) {
			if(pos>min) {
				distance += (max-pos) + (max-requests[requests.length-1]);
			}else {
				distance += requests[0]-pos;
			}
		}else {
			if(pos<max) {
				distance += (pos-min) + (requests[0]-min);
			}else {
				distance += requests[0]-pos;
			}
		}
		
		
		return distance;
	}
	

	public int C_SCAN(int[] requests, int pos, int max, int min) {
		int distance = max-min;
		Arrays.sort(requests);
		
		if(pos!=min) {
			if(pos==requests[0]) {
				distance -= requests[0]-min;
			}else {
				for(int i=1; i<requests.length; i++) {
					if(requests[i]>=pos) {
						distance -= pos - requests[i-1];
						break;
					}
				}
			}
		}
		
		if(pos>requests[0]) {
			distance+=(max-min);
		}
		
		return distance;
	}
}
