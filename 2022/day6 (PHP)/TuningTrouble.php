<?php

$inputSignal = file_get_contents("./input.txt");

$pIndex = 0;
$packetLength = 4;
$startPacket = substr($inputSignal, $pIndex, $packetLength);

while (!checkPacket($startPacket)) {
    $pIndex++;
    $startPacket = substr($inputSignal, $pIndex, $packetLength);
}


$mIndex = 0;
$messageLength = 14;
$startMessage = substr($inputSignal, $mIndex, $messageLength);

while (!checkPacket($startMessage)) {
    $mIndex++;
    $startMessage = substr($inputSignal, $mIndex, $messageLength);
}



echo ("Part One Answer:\n");
echo ("Start Packet: ");
echo ($startPacket);
echo ("\n");
echo ("Index of packet: ");
echo ($pIndex + 4);
echo ("\n\n");

echo ("Part Two Answer:\n");
echo ("Start Message: ");
echo ($startMessage);
echo ("\n");
echo ("Index of Message: ");
echo ($mIndex + 14);
echo ("\n\n");



function checkPacket($pkt)
{

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
