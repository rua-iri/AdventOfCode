<?php


$commandList = file_get_contents("./input.txt");
$commandAra = explode("\n", $commandList);

$dirAra = [];
$dirSizes = array();

for ($i = 0; $i < count($commandAra); $i++) {


    $commandComponents = explode(" ", $commandAra[$i]);

    //add all directories to the array
    if ($commandComponents[1] == "cd") {

        if ($commandComponents[2] == "..") {
            array_pop($dirAra);
        } else {
            array_push($dirAra, $commandComponents[2]);
        }
    } else if ($commandComponents[1] == "ls") {
        continue;
    } else {

        if ($commandComponents[0] != "dir") {

            $size = intval($commandComponents[0]);

            for ($x = 1; $x <= count($dirAra); $x++) {
                
                $dPath = "/" . implode(array_slice($dirAra, 0, $x));

                if(array_key_exists($dPath, $dirSizes)) {
                    $dirSizes[$dPath] += $size;
                } else {
                    $dirSizes[$dPath] = $size;
                }

            }
        }
    }
}



$totalNotBigDirs = 0;

foreach ($dirSizes as $dirName => $sze) {
    if ($sze <= 100000) {
        $totalNotBigDirs += $sze;
    }
}

echo ("Part One Solution:\n");
echo ($totalNotBigDirs);
