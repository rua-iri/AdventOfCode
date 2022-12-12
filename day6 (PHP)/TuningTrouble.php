<?php

$inputSignal = file_get_contents("./input.txt");

$pIndex = 0;
$packetLength = 4;
$startPacket = substr($inputSignal, $pIndex, $packetLength);

checkPacket($startPacket);



while (!checkPacket($startPacket)) {
    $pIndex++;
    $startPacket = substr($inputSignal, $pIndex, $packetLength);
}



echo("Part One Answer:\n");
echo("Start Packet: ");
echo($startPacket);
echo("\n");
echo("Index of packet: ");
echo($pIndex + 4);
echo("\n");


function checkPacket($pkt) {

    $pktChars = str_split($pkt);

    //iterate through each char in the packet
    foreach ($pktChars as $chr) {
        $numDuplicates = substr_count($pkt, $chr);

        //if packet occurs more than once then there is duplication
        if ($numDuplicates > 1) {
            return false;
        }
    }

    return true;
}
